import 'package:flutter/material.dart';
import 'package:hotel_management_system/pages/frontPage/CustomDateRangePicker.dart';

class FullPageDataRangePickerDialog extends StatelessWidget {
  const FullPageDataRangePickerDialog({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Wybierz datę pobytu"),
      ),
      backgroundColor: Theme.of(context).backgroundColor,
      body: Container(
        child: CustomDateRangePicker(),
      ),
    );
  }
}
