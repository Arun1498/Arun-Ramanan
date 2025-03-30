import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_app/services/api_service.dart';
import 'package:flutter/material.dart';


class ItemDetailsScreen extends StatelessWidget {
  final String itemId;

  ItemDetailsScreen({required this.itemId});

  
  Future<double> _getINRtoUSD() async {
    ApiService apiService = ApiService();
    try {
      final data = await apiService.fetchExchangeRates();
      
      return data['rates']['INR'] ?? 0.0;  
    } catch (e) {
      throw Exception('Failed to fetch USD conversion rate');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          'Item Details',
          style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24),
        ),
        backgroundColor: Colors.purple[700],
      ),
      body: FutureBuilder<DocumentSnapshot>(
        future: FirebaseFirestore.instance.collection('items').doc(itemId).get(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          }

          if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          }

          if (!snapshot.hasData || !snapshot.data!.exists) {
            return Center(child: Text('Item not found'));
          }

          final item = snapshot.data!;
          final name = item['name'] ?? 'No Name';
          final category = item['category'] ?? 'No Category';
          final stock = item['stock'] ?? 0;
          final price = item['price'] ?? 0.0;
          final imageUrl = item['imageUrl'];
          final costOfGoods = stock * price;

          return FutureBuilder<double>(
            future: _getINRtoUSD(),
            builder: (context, usdSnapshot) {
              if (usdSnapshot.connectionState == ConnectionState.waiting) {
                return Center(child: CircularProgressIndicator());
              }

              if (usdSnapshot.hasError) {
                return Center(child: Text('Error fetching conversion rate'));
              }

              double inrToUsdRate = usdSnapshot.data ?? 0.0; 
              double priceInUSD = price / inrToUsdRate; 
              double totalCostInUSD = costOfGoods / inrToUsdRate; 

              return Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    if (imageUrl != null)
                      Image.network(imageUrl, height: 150, width: 150, fit: BoxFit.cover),
                    SizedBox(height: 16),
                    Text(
                      'Name: $name',
                      style: TextStyle(
                        fontSize: 24,
                        fontWeight: FontWeight.bold,
                        color: Colors.purple[800],
                      ),
                    ),
                    SizedBox(height: 8),
                    Text(
                      'Category: $category',
                      style: TextStyle(
                        fontSize: 18,
                        color: Colors.purple[600],
                      ),
                    ),
                    SizedBox(height: 8),
                    Text(
                      'Stock: $stock units',
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.purple[400],
                      ),
                    ),
                    SizedBox(height: 8),
                    Text(
                      'Price: ₹${price.toStringAsFixed(2)} per unit',
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.purple[400],
                      ),
                    ),
                    SizedBox(height: 8),
                    Text(
                      'Total Cost: ₹${costOfGoods.toStringAsFixed(2)}',
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.purple[400],
                      ),
                    ),
                    SizedBox(height: 8),
                    Text(
                      'Price in USD: \$${priceInUSD.toStringAsFixed(2)} per unit',
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.purple[400],
                      ),
                    ),
                    SizedBox(height: 8),
                    Text(
                      'Total Cost in USD: \$${totalCostInUSD.toStringAsFixed(2)}',
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.purple[400],
                      ),
                    ),
                    SizedBox(height: 20),
                    ElevatedButton(
                      onPressed: () {
                        Navigator.pop(context);
                      },
                      child: Text('Go Back', style: TextStyle(color: Colors.white)),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.purple[600],
                        padding: EdgeInsets.symmetric(vertical: 12, horizontal: 24),
                        textStyle: TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    SizedBox(height: 20),
                    ElevatedButton(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => EditItemScreen(itemId: itemId),
                          ),
                        );
                      },
                      child: Text(
                        'Edit Item',
                        style: TextStyle(color: Colors.white),
                      ),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.purple[600],
                        padding: EdgeInsets.symmetric(vertical: 12, horizontal: 24),
                        textStyle: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                      ),
                    ),
                  ],
                ),
              );
            },
          );
        },
      ),
    );
  }
}

class EditItemScreen extends StatefulWidget {
  final String itemId;

  EditItemScreen({required this.itemId});

  @override
  _EditItemScreenState createState() => _EditItemScreenState();
}

class _EditItemScreenState extends State<EditItemScreen> {
  final TextEditingController _nameController = TextEditingController();
  final TextEditingController _categoryController = TextEditingController();
  final TextEditingController _stockController = TextEditingController();
  final TextEditingController _priceController = TextEditingController();

  @override
  void initState() {
    super.initState();
    FirebaseFirestore.instance.collection('items').doc(widget.itemId).get().then((doc) {
      if (doc.exists) {
        final item = doc.data();
        _nameController.text = item?['name'] ?? '';
        _categoryController.text = item?['category'] ?? '';
        _stockController.text = item?['stock'].toString() ?? '';
        _priceController.text = item?['price'].toString() ?? '';
      }
    });
  }

  void _saveChanges() {
    FirebaseFirestore.instance.collection('items').doc(widget.itemId).update({
      'name': _nameController.text,
      'category': _categoryController.text,
      'stock': int.parse(_stockController.text),
      'price': double.parse(_priceController.text),
    }).then((_) {
      Navigator.pop(context);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Edit Item'),
        backgroundColor: Colors.purple[700],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _nameController,
              decoration: InputDecoration(labelText: 'Item Name'),
            ),
            TextField(
              controller: _categoryController,
              decoration: InputDecoration(labelText: 'Category'),
            ),
            TextField(
              controller: _stockController,
              decoration: InputDecoration(labelText: 'Stock'),
              keyboardType: TextInputType.number,
            ),
            TextField(
              controller: _priceController,
              decoration: InputDecoration(labelText: 'Price'),
              keyboardType: TextInputType.numberWithOptions(decimal: true),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: _saveChanges,
              child: Text(
                'Save Changes',
                style: TextStyle(color: Colors.white),
              ),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.purple[600],
                padding: EdgeInsets.symmetric(vertical: 12, horizontal: 24),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
