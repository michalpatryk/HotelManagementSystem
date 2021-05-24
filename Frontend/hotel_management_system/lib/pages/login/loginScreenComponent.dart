import 'package:flutter/material.dart';
import 'package:hotel_management_system/utils/colorTheme.dart';

class LoginScreenComponent extends StatelessWidget {
  const LoginScreenComponent({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    ColorTheme myColors = ColorTheme();
    return Container(
      child: Row(
        children: [
          Expanded(
            // child: FittedBox(
            //   child: Image.asset('assets/loginPhoto.png'),
            //   fit: BoxFit.fill,
            // ),
            child: Container(),
          ),
          Expanded(
            //flex: 3,
            child: Container(
                color: Colors.amber,
                child: Column(
                  children: [
                    Container(
                      child: Text(
                        "Dashboard",
                        style: TextStyle(
                          color: myColors.themeData.colorScheme.primary,
                          fontSize: 46,
                          fontFamily: 'Anton',
                        ),
                      ),
                    ),
                    Container(
                      color: Colors.blue,
                      child: Text("ELO"),
                    ),
                  ],
                )),
          ),
        ],
      ),
    );
  }
}
