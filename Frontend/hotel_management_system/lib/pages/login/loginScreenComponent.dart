import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:hotel_management_system/components/HeadingText.dart';
import 'package:hotel_management_system/components/filledRoundedButton.dart';
import 'package:hotel_management_system/utils/colorTheme.dart';

class LoginScreenComponent extends StatelessWidget {
  const LoginScreenComponent({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    ColorTheme myColors = ColorTheme();
    return Container(
      margin: EdgeInsets.fromLTRB(300, 200, 300, 200),
      decoration: BoxDecoration(
          border: Border.all(
            color: Colors.black,
          ),
          borderRadius: BorderRadius.all(Radius.circular(20))),
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
                      padding: EdgeInsets.fromLTRB(0, 20, 0, 0),
                      child: HeadingText(text: 'Dashboard'),
                    ),
                    Container(
                      padding: EdgeInsets.fromLTRB(40, 20, 40, 20),
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
                            decoration: InputDecoration(
                                hintText: 'Podaj adres email',
                                contentPadding: EdgeInsets.all(4)),
                          ))
                        ],
                      ),
                    ),
                    Container(
                      padding: EdgeInsets.fromLTRB(40, 0, 40, 20),
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
                            decoration: InputDecoration(
                                hintText: 'Podaj hasło',
                                contentPadding: EdgeInsets.all(4)),
                          ))
                        ],
                      ),
                    ),
                    FilledRoundedButton(
                      buttonText: 'zaloguj się',
                      onPresesd: () => {},
                    ),
                    Container(
                      padding: EdgeInsets.fromLTRB(0, 10, 0, 0),
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
