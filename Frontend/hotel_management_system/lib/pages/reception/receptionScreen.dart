import 'package:flutter/material.dart';
import 'package:hotel_management_system/components/navigationComponent.dart';
import 'package:hotel_management_system/components/topBar.dart';
import 'package:hotel_management_system/utils/colorTheme.dart';

class ReceptionScreen extends StatelessWidget {
  const ReceptionScreen({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    ColorTheme colorTheme = ColorTheme();
    return Container(
      child: Row(
        children: <Widget>[
          Container(
            width: 300,
            child: NavigationComponent(),
          ),
          Expanded(
            child: Column(
              children: [
                TopBar(),
                Expanded(
                  flex: 5,
                  child: Container(
                    color: Colors.green,
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
