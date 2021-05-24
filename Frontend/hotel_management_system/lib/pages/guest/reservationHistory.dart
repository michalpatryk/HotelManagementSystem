import 'package:flutter/material.dart';
import 'package:hotel_management_system/components/basicContainerShadow.dart';

class ReservationHistory extends StatefulWidget {
  ReservationHistory({Key key}) : super(key: key);

  @override
  _ReservationHistoryState createState() => _ReservationHistoryState();
}

class _ReservationHistoryState extends State<ReservationHistory> {
  @override
  Widget build(BuildContext context) {
    return Material(
      child: BasicContainerShadow(
        width: 530,
        height: 310,
        child: Padding(
          padding: const EdgeInsets.all(14.0),
          child: Column(
            children: [
              Row(
                children: [
                  Icon(Icons.history_rounded),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(14, 0, 0, 0),
                    child: Text(
                      "Historia rezerwacji",
                      style: TextStyle(
                        fontSize: 24,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ],
              ),
              SizedBox(height: 24,),
              singleHistoryRow(),
              singleHistoryRow(),
              singleHistoryRow(),
            ],
          ),
        ),
      ),
    );
  }

  Widget singleHistoryRow() {
    return Padding(
      padding: const EdgeInsets.fromLTRB(16, 8, 16, 8),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Text(
            "Pokój 4-os",
            style: TextStyle(
              fontSize: 16,
              fontWeight: FontWeight.w500,
            ),
          ),
          Text(
            "17.03.2020 - 23.03.2020",
            style: TextStyle(
              fontSize: 16,
              fontWeight: FontWeight.w500,
            ),
          ),
        ],
      ),
    );
  }
}
