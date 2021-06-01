import 'package:flutter/material.dart';

class IconText extends StatelessWidget {
  const IconText(
      {Key? key,
      this.icon = Icons.add,
      this.text = "IconText",
      this.color = Colors.black87,
      this.fontSize = 16.0})
      : super(key: key);

  final IconData icon;
  final String text;
  final Color color;
  final double fontSize;

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Icon(
          icon,
          color: color,
          size: fontSize,
        ),
        Padding(
          padding: const EdgeInsets.fromLTRB(6, 0, 0, 0),
          child: Text(
            text,
            style: TextStyle(fontSize: fontSize, color: color),
          ),
        ),
      ],
    );
  }
}
