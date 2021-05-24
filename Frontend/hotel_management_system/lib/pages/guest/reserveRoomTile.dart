import 'package:flutter/material.dart';
import 'package:hotel_management_system/components/basicContainerShadow.dart';

class ReserveRoomtile
 extends StatelessWidget {
  const ReserveRoomtile
  ({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return BasicContainerShadow(
      height: 150,
      width: 530,
      color: Theme.of(context).colorScheme.secondary,
      child: Text("dupa123"),
    );
  }
}