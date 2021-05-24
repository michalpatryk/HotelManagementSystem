import 'package:flutter/material.dart';
import 'package:hotel_management_system/components/basicContainerShadow.dart';
import 'package:hotel_management_system/components/roundButton.dart';

class ReserveRoomtile extends StatelessWidget {
  const ReserveRoomtile({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return BasicContainerShadow(
      height: 150,
      width: 530,
      color: Theme.of(context).colorScheme.secondary,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Icon(
                  Icons.bookmark,
                  color: Colors.white,
                ),
                Padding(
                  padding: const EdgeInsets.fromLTRB(14, 0, 0, 0),
                  child: Text(
                    "Zarezerwuj pokój",
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 24,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
              ],
            ),
          ),
          RoundButton(
            text: "Przejdź do rezerwacji",
            color: Theme.of(context).primaryColor,
            padding: const EdgeInsets.fromLTRB(60, 14, 60, 14),
          ),
        ],
      ),
    );
  }
}
