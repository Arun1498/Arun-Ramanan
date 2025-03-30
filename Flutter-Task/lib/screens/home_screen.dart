import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_app/localization/en.dart' as en;
import 'package:firebase_app/localization/en.dart';
import 'package:firebase_app/localization/hi.dart' as hi;
import 'package:firebase_app/models/item.dart';
import 'package:firebase_app/screens/add_item_screen.dart';
import 'package:firebase_app/screens/item_details_screen.dart';
import 'package:firebase_app/services/firebase_service.dart';
import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';


class HomeScreen extends StatefulWidget {
  final Function onLanguageToggle;

  HomeScreen({required this.onLanguageToggle});

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final FirebaseService _firebaseService = FirebaseService();
  TextEditingController _searchController = TextEditingController();
  List<Item> _allItems = [];
  List<Item> _filteredItems = [];

  @override
  void initState() {
    super.initState();
    _firebaseService.getItems().listen((items) {
      setState(() {
        _allItems = items;
        _filteredItems = items;
      });
    });
  }

  void _filterItems(String query) {
    final filteredItems = _allItems.where((item) {
      return item.name.toLowerCase().contains(query.toLowerCase());
    }).toList();

    setState(() {
      _filteredItems = filteredItems;
    });
  }

  void _deleteItem(String itemId) {
    _firebaseService.deleteItem(itemId);
    setState(() {
      _filteredItems.removeWhere((item) => item.id == itemId);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.purple[50],
      appBar: AppBar(
        title: Text(
          AppLocalizations.of(context)?.appTitle ?? 'DukaanDost Inventory',
          style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24),
        ),
        backgroundColor: Colors.purple[700],
        elevation: 4,
        bottom: PreferredSize(
          preferredSize: Size.fromHeight(60),
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: _searchController,
              onChanged: _filterItems,
              decoration: InputDecoration(
                hintText: AppLocalizations.of(context)?.appTitle ?? 'Search by item name...',
                prefixIcon: Icon(Icons.search, color: Colors.purple[600]),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(12),
                  borderSide: BorderSide.none,
                ),
                filled: true,
                fillColor: Colors.white,
              ),
            ),
          ),
        ),
        actions: [
          Switch(
            value: Localizations.localeOf(context).languageCode == 'hi',
            onChanged: (value) {
              widget.onLanguageToggle();  
            },
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: ListView.builder(
          itemCount: _filteredItems.length,
          itemBuilder: (context, index) {
            final item = _filteredItems[index];
            return Card(
              elevation: 4,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(12),
              ),
              margin: EdgeInsets.symmetric(vertical: 6),
              color: Colors.grey[200],
              child: ListTile(
                contentPadding: EdgeInsets.all(16),
                leading: item.imageUrl != null && item.imageUrl!.isNotEmpty
                    ? Image.network(
                        item.imageUrl!,
                        width: 50,
                        height: 50,
                        fit: BoxFit.cover,
                      )
                    : Icon(Icons.image, size: 50, color: Colors.purple[400]),
                title: Text(
                  item.name,
                  style: TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                    color: Colors.purple[800],
                  ),
                ),
                subtitle: Text(
                  item.category,
                  style: TextStyle(
                    fontSize: 14,
                    color: Colors.purple[600],
                  ),
                ),
                trailing: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    Text(
                      '${item.stock} units',
                      style: TextStyle(
                        fontSize: 14,
                        color: Colors.purple[400],
                      ),
                    ),
                    IconButton(
                      icon: Icon(Icons.delete, color: Colors.red),
                      onPressed: () => _deleteItem(item.id),
                    ),
                  ],
                ),
                onTap: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => ItemDetailsScreen(itemId: item.id),
                    ),
                  );
                },
              ),
            );
          },
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => AddItemScreen()),
          );
        },
        backgroundColor: Colors.purple[600],
        child: Icon(
          Icons.add,
          color: Colors.white,
        ),
        elevation: 6,
      ),
    );
  }
}
