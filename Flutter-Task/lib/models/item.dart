import 'package:cloud_firestore/cloud_firestore.dart';

class Item {
  final String id;
  final String name;
  final String category;
  final int stock;
  final double price;
  final String? imageUrl; 

  Item({
    required this.id,
    required this.name,
    required this.category,
    required this.stock,
    required this.price,
    this.imageUrl,
  });

  factory Item.fromFirestore(DocumentSnapshot doc) {
    Map data = doc.data() as Map;
    return Item(
      id: doc.id,
      name: data['name'] ?? '',
      category: data['category'] ?? '',
      stock: data['stock'] ?? 0,
      price: data['price'] ?? 0.0,
      imageUrl: data['imageUrl'], 
    );
  }

  
  Map<String, dynamic> toMap() {
    return {
      'name': name,
      'category': category,
      'stock': stock,
      'price': price,
      'imageUrl': imageUrl, 
    };
}
}