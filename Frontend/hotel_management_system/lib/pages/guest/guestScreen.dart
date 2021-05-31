import 'package:flutter/material.dart';
import 'package:hotel_management_system/components/navigationComponent.dart';
import 'package:hotel_management_system/components/topBar.dart';
import 'package:hotel_management_system/pages/guest/actualReservations.dart';
import 'package:hotel_management_system/utils/colorTheme.dart';
import 'package:hotel_management_system/pages/guest/reservationHistory.dart';
import 'package:hotel_management_system/pages/guest/reserveRoomTile.dart';

class GuestScreen extends StatelessWidget {
  const GuestScreen({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    ColorTheme colorTheme = ColorTheme();
    return Scaffold(
      body: Container(
        color: Colors.white,
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
                  ReservationHistory(),
                  ReserveRoomtile(),
                  ActualReservations(),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}