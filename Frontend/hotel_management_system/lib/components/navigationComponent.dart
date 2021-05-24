import 'package:flutter/material.dart';
import 'package:hotel_management_system/utils/colorTheme.dart';

class NavigationComponent extends StatefulWidget {
  NavigationComponent({Key key}) : super(key: key);

  @override
  _NavigationComponentState createState() => _NavigationComponentState();
}

class _NavigationComponentState extends State<NavigationComponent> {
  @override
  Widget build(BuildContext context) {
    ColorTheme myColors = ColorTheme();
    return Material(
      color: myColors.themeData.colorScheme.primary,
      child: Container(
        child: Column(
          children: [
            Expanded(
              child: Container(color: myColors.themeData.colorScheme.background),
            ),
            Expanded(
              flex: 4,
              child: Container(
                child: ListView.builder(
                  itemCount: 5,
                  itemBuilder: (context, index) {
                    return ListTile(
                      title: Text('Basic text: ' + index.toString()),
                      leading: Icon(Icons.home),
                      onTap: () => {},
                    );
                  },
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
