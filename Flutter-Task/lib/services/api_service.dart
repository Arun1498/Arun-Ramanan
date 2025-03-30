import 'dart:convert';
import 'package:http/http.dart' as http;

class ApiService {
  final String _baseUrl = 'https://api.exchangerate-api.com/v4/latest/USD';

  Future<Map<String, dynamic>> fetchExchangeRates() async {
    final response = await http.get(Uri.parse(_baseUrl));

    if (response.statusCode == 200) {
      return json.decode(response.body);
    } else {
      throw Exception('Failed to load exchange rates');
    }
  }
}
