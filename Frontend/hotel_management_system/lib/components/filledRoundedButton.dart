import 'package:flutter/material.dart';

class FilledRoundedButton extends StatelessWidget {
  const FilledRoundedButton({
    Key key,
    this.buttonText,
    this.onPresesd,
  }) : super(key: key);

  final String buttonText;
  final Function onPresesd;

  @override
  Widget build(BuildContext context) {
    return TextButton(
      style: ButtonStyle(
        backgroundColor:
            MaterialStateProperty.all(Theme.of(context).primaryColor),
        shape: MaterialStateProperty.all<RoundedRectangleBorder>(
          RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(18.0),
            side: BorderSide(color: Theme.of(context).primaryColor),
          ),
        ),
        padding: MaterialStateProperty.all<EdgeInsets>(
          EdgeInsets.symmetric(horizontal: 40.0, vertical: 15.0),
        ),
      ),
      onPressed: onPresesd,
      child: Text(
        buttonText.toUpperCase(),
        style: TextStyle(
          color: Colors.white,
          fontSize: 16.0,
          fontWeight: FontWeight.w500,
        ),
      ),
    );
  }
}
