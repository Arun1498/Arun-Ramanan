import 'package:firebase_app/localization/en.dart' as en;
import 'package:firebase_app/localization/hi.dart' as hi;
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'screens/home_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  Locale _locale = Locale('en');

  void _toggleLanguage() {
    setState(() {
      _locale = _locale.languageCode == 'en' ? Locale('hi') : Locale('en');
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      locale: _locale,
      supportedLocales: [Locale('en'), Locale('hi')],
      localizationsDelegates: [
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        en.AppLocalizations.delegate,
        hi.AppLocalizations.delegate,
      ],
      home: HomeScreen(onLanguageToggle: _toggleLanguage),
    );
  }
}
