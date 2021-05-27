import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:syncfusion_flutter_datepicker/datepicker.dart';

/// My app class to display the date range picker
class CustomDateRangePicker extends StatefulWidget {
  @override
  CustomDateRangePickerState createState() => CustomDateRangePickerState();
}

/// State for MyApp
class CustomDateRangePickerState extends State<CustomDateRangePicker> {
  String _range = "";
  DateTime _startDate = DateTime.now().add(const Duration(days: 1));
  DateTime _endDate = DateTime.now().add(const Duration(days: 8));
  int _allDays = 7;
  double _costPerDay = 250.0;
  double _wholeCost = 7 * 250.0;
  Function confirmButton;

  void _onSelectionChanged(DateRangePickerSelectionChangedArgs args) {
    setState(() {
      if (args.value is PickerDateRange) {
        _range = DateFormat('dd/MM/yyyy').format(args.value.startDate).toString() +
            ' - ' +
            DateFormat('dd/MM/yyyy').format(args.value.endDate ?? args.value.startDate).toString();
        _startDate = args.value.startDate;
        _endDate = args.value.endDate ?? args.value.startDate;
        _allDays = _endDate.difference(_startDate).inDays;
        _wholeCost = _allDays * _costPerDay;

        validateDateRange();
      }
    });
  }

  validateDateRange() {
    if (isBlackoutDaysContainsInRangeDate()) {
      _showAlertDateDialog();
      confirmButton = null;
    } else {
      confirmButton = confirm;
    }

    if (_allDays == 0) {
      confirmButton = null;
    }
  }

  List<DateTime> _blackoutDates = [
    DateTime.now().add(const Duration(days: 1)),
    DateTime.now().add(const Duration(days: 3)),
  ];

  confirm() {
    print("Confirm pressed");
  }

  goBack(BuildContext context) {
    print("GoBack pressed");
    Navigator.pop(context);
  }

  bool isBlackoutDaysContainsInRangeDate() {
    for (var day in _blackoutDates) {
      if (day.isAfter(_startDate) && day.isBefore(_endDate)) return true;
    }
    return false;
  }

  Future<void> _showAlertDateDialog() async {
    return showDialog<void>(
      context: context,
      barrierDismissible: false, // user must tap button!
      builder: (BuildContext context) {
        return AlertDialog(
          title: const Text('Błąd'),
          content: SingleChildScrollView(
            child: ListBody(
              children: const <Widget>[
                Text('Zakres dat nie może zawierać nieaktywnych terminów'),
              ],
            ),
          ),
          actions: <Widget>[
            TextButton(
              child: const Text('Ok'),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Card(
            color: Colors.white,
            elevation: 2.0,
            child: Container(
              padding: const EdgeInsets.all(20),
              width: 350,
              height: 600,
              child: buildLeftBar(context),
            ),
          ),
          SizedBox(
            width: 20,
          ),
          Card(
            color: Colors.white,
            elevation: 2.0,
            child: Container(
              padding: const EdgeInsets.all(20),
              height: 600,
              width: 800,
              child: buildDataPicker(context),
            ),
          ),
        ],
      ),
    );
  }

  Widget buildDataPicker(BuildContext context) {
    return SfDateRangePicker(
      enableMultiView: true,
      rangeSelectionColor: Theme.of(context).primaryColor.withOpacity(.5),
      startRangeSelectionColor: Theme.of(context).primaryColor,
      endRangeSelectionColor: Theme.of(context).primaryColor,
      todayHighlightColor: Theme.of(context).colorScheme.secondaryVariant,
      onSelectionChanged: _onSelectionChanged,
      minDate: DateTime.now(),
      selectionColor: Theme.of(context).primaryColor.withOpacity(.3),
      monthCellStyle: DateRangePickerMonthCellStyle(
          blackoutDateTextStyle: const TextStyle(color: Colors.red, decoration: TextDecoration.lineThrough)),
      monthViewSettings: DateRangePickerMonthViewSettings(firstDayOfWeek: 1, blackoutDates: _blackoutDates),
      selectionMode: DateRangePickerSelectionMode.range,
      initialSelectedRange: PickerDateRange(_startDate, _endDate),
    );
  }

  Widget buildLeftBar(BuildContext context) {
    return Column(
      children: [
        Expanded(
          child: ListView(
            children: [
              ListTile(
                leading: Text("Początek pobytu"),
                trailing: Text(DateFormat('dd-MM-yyyy').format(_startDate).toString()),
              ),
              ListTile(
                leading: Text("Koniec pobytu"),
                trailing: Text(DateFormat('dd-MM-yyyy').format(_endDate).toString()),
              ),
              ListTile(
                leading: Text("Ilość nocy"),
                trailing: Text(_allDays.toString()),
              ),
              ListTile(
                leading: Text("Cena za dobę"),
                trailing: Text("${_costPerDay}zł"),
              ),
              ListTile(
                leading: Text("Koszt"),
                trailing: Text("${_wholeCost}zł"),
              ),
            ],
          ),
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.end,
          children: [
            TextButton(
              onPressed: () => goBack(context),
              child: Text("powrót".toUpperCase()),
            ),
            SizedBox(
              width: 20.0,
            ),
            TextButton(
              onPressed: confirmButton,
              child: Text("Zatwierdź".toUpperCase()),
            ),
          ],
        )
      ],
    );
  }
}
