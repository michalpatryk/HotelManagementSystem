abstract class Bed {
  int get size;
  int count;

  @override
  String toString();
}

class SingleBed extends Bed {
  int get size => 1;

  @override
  String toString() {
    return "pojedyńcze";
  }
}

class MatrimonialBed extends Bed {
  int get size => 2;

  @override
  String toString() {
    return "małżeśnkie";
  }
}
