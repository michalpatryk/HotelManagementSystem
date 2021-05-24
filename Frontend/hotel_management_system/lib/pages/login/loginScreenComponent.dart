import 'package:flutter/gestures.dart';
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
            child: Container(
              child: Image(
                image: AssetImage('assets/loginPhoto.png'),
              ),
            ),
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
                    Container(),
                    Container(),
                    Container(
                      child: RichText(
                        text: TextSpan(
                            text: 'Nie masz konta? ',
                            style: TextStyle(
                              color: Colors.black,
                              fontSize: 12,
                              fontFamily: 'Roboto',
                            ),
                            children: <TextSpan>[
                              TextSpan(
                                  text: 'Zarejestruj się',
                                  recognizer: TapGestureRecognizer()
                                    ..onTap = () {
                                      print('Button clicked');
                                    },
                                  style: TextStyle(
                                    color:
                                        myColors.themeData.colorScheme.primary,
                                  ))
                            ]),
                      ),
                    ),
                  ],
                )),
          ),
        ],
      ),
    );
  }
}
