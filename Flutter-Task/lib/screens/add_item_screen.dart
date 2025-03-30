import 'package:firebase_app/models/item.dart';
import 'package:firebase_app/services/firebase_service.dart';
import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'package:firebase_storage/firebase_storage.dart';
import 'dart:io';

class AddItemScreen extends StatefulWidget {
  @override
  _AddItemScreenState createState() => _AddItemScreenState();
}

class _AddItemScreenState extends State<AddItemScreen> {
  final FirebaseService _firebaseService = FirebaseService();

  final TextEditingController _nameController = TextEditingController();
  final TextEditingController _categoryController = TextEditingController();
  final TextEditingController _stockController = TextEditingController();
  final TextEditingController _priceController = TextEditingController();
  final TextEditingController _imageUrlController = TextEditingController();  

  File? _imageFile;

  final ImagePicker _picker = ImagePicker();

  
  Future<void> _pickImage() async {
    final XFile? pickedFile = await _picker.pickImage(source: ImageSource.gallery);
    if (pickedFile != null) {
      setState(() {
        _imageFile = File(pickedFile.path);
      });
    }
  }

  
  Future<String?> _uploadImage(File imageFile) async {
    try {
      String fileName = DateTime.now().millisecondsSinceEpoch.toString();
      Reference storageRef = FirebaseStorage.instance.ref().child('item_images/$fileName');

      UploadTask uploadTask = storageRef.putFile(imageFile);
      TaskSnapshot snapshot = await uploadTask.whenComplete(() {});

      String downloadURL = await snapshot.ref.getDownloadURL();
      return downloadURL;
    } catch (e) {
      print("Image upload failed: $e");
      return null;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Add Item'),
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
  onPressed: _pickImage,
  child: Text(
    'Pick Image',
    style: TextStyle(color: Colors.white), 
  ),
  style: ElevatedButton.styleFrom(
    backgroundColor: Colors.purple[600],
    padding: EdgeInsets.symmetric(vertical: 12, horizontal: 24), 
  ),
),
            SizedBox(height: 10),

            
            if (_imageFile != null)
              Image.file(_imageFile!, height: 150, width: 150, fit: BoxFit.cover),

            SizedBox(height: 20),

            
            TextField(
              controller: _imageUrlController,
              decoration: InputDecoration(labelText: 'Or Enter Image URL'),
            ),

            SizedBox(height: 20),

            
            ElevatedButton(
              onPressed: () async {
                String? imageUrl;

                
                if (_imageFile != null) {
                  imageUrl = await _uploadImage(_imageFile!);
                } else if (_imageUrlController.text.isNotEmpty) {
                  
                  imageUrl = _imageUrlController.text;
                }

                
                _firebaseService.addItem(
                  Item(
                    name: _nameController.text,
                    category: _categoryController.text,
                    stock: int.parse(_stockController.text),
                    price: double.parse(_priceController.text),
                    id: '', 
                    imageUrl: imageUrl, 
                  ),
                );

                
                Navigator.pop(context);
              },
              child: Text(
    'Add Item',
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
