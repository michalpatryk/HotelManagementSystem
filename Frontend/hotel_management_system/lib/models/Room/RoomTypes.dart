abstract class RoomType {
  int count;

  @override
  String toString();
}

class LivingRoom extends RoomType {
  @override
  String toString() {
    return "Salon";
  }
}

class Kitchen extends RoomType {
  @override
  String toString() {
    return "Kuchnia";
  }
}

class Bedroom extends RoomType {
  @override
  String toString() {
    return "sypialnia";
  }
}

class Bathroom extends RoomType {
  @override
  String toString() {
    return "Łazienka";
  }
}
