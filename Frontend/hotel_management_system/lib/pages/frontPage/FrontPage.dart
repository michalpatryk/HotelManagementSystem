import 'package:flutter/material.dart';
import 'package:hotel_management_system/components/outlinedRoundedButton.dart';
import 'package:hotel_management_system/pages/frontPage/FrontPageAppBar.dart';

class FrontPage extends StatelessWidget {
  const FrontPage({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.transparent,
      appBar: FrontPageAppBar(),
      body: Text("Elo"),
    );
  }
}
