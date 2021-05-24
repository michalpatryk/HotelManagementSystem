import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:hotel_management_system/components/filledRoundedButton.dart';
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
              decoration: BoxDecoration(
                image: DecorationImage(
                  image: AssetImage('assets/loginPhoto.png'),
                  fit: BoxFit.cover,
                ),
              ),
            ),
          ),
          Expanded(
            //flex: 3,
            child: Container(
                color: Colors.white,
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
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.stretch,
                        children: [
                          Text(
                            "Email",
                            style: TextStyle(
                              color: myColors.themeData.colorScheme.primary,
                              fontSize: 12,
                              fontFamily: 'RobotoMono',
                            ),
                          ),
                          Material(
                              child: TextField(
                            decoration:
                                InputDecoration(hintText: 'Podaj adres email'),
                          ))
                        ],
                      ),
                    ),
                    Container(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.stretch,
                        children: [
                          Text("Hasło",
                              style: TextStyle(
                                color: myColors.themeData.colorScheme.primary,
                                fontSize: 12,
                                fontFamily: 'RobotoMono',
                              )),
                          Material(
                              child: TextField(
                            decoration:
                                InputDecoration(hintText: 'Podaj hasło'),
                          ))
                        ],
                      ),
                    ),
                    FilledRoundedButton(
                      buttonText: 'zaloguj się',
                      onPresesd: () => {},
                    ),
                    Container(
                      child: RichText(
                        text: TextSpan(
                            text: 'Nie masz konta? ',
                            style: TextStyle(
                              color: Colors.black,
                              fontSize: 12,
                              fontFamily: 'RobotoMono',
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
