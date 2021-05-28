import 'package:hotel_management_system/models/Room/RoomTypes.dart';

import 'Beds.dart';

class Room {
  int id;
  String name;
  int size;
  double price;
  List<Bed> beds;
  List<RoomType> rooms;
  List<DateTime> blackoutDays;
  Uri imageURL;
}
