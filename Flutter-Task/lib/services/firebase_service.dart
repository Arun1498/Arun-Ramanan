import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_app/models/item.dart';

class FirebaseService {
  final FirebaseFirestore _db = FirebaseFirestore.instance;

 
  Stream<List<Item>> getItems() {
    return _db.collection('items').snapshots().map((snapshot) {
      return snapshot.docs.map((doc) => Item.fromFirestore(doc)).toList();
    });
  }

  
  Future<void> deleteItem(String itemId) async {
    try {
      await _db.collection('items').doc(itemId).delete();
    } catch (e) {
      print('Error deleting item: $e');
    }
  }

  
   Future<void> updateItem(String itemId, Item item) async {
    try {
      await _db.collection('items').doc(itemId).update({
        'name': item.name,
        'category': item.category,
        'stock': item.stock,
        'price': item.price,
      });
    } catch (e) {
      print('Error updating item: $e');
    }
  }

  
  Future<void> addItem(Item item) async {
    try {
      await _db.collection('items').add(item.toMap());
    } catch (e) {
      print('Error adding item: $e');
    }
  }
}
