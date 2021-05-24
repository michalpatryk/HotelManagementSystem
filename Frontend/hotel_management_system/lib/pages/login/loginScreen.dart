import 'package:flutter/material.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Row(
        children: [
          Expanded(
            child: FittedBox(
              child: Image.asset('assets/loginPhoto.png'),
              fit: BoxFit.fill,
            ),
          ),
          Expanded(
            //flex: 3,
            child: Container(
              color: Colors.amber,
            ),
          ),
        ],
      ),
    );
  }
}
