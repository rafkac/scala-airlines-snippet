import scala.collection.mutable.HashSet

object Main {

  case class Flight(flightNo: String, origin: String, destination: String)
  val flights = HashSet.empty[Flight]
  // TO-DO: populate flights with data

  def findFlight(flightNo: String): Option[Flight] = {
    flights.foreach { f =>
      if (f.flightNo == flightNo) {
        return Some(f)
      }
    }
    None
  }



  case class Seat(id: String)

  def createSeats(rows: Int, seatsInRow: Int, firstRowNumber: Int): List[Seat] = {

    def seatId(n: Int, letter: Char): Seat = Seat(n.toString :+ letter)

    (for (n <- firstRowNumber until firstRowNumber + rows;
          letter <- 'A' until ('A' + seatsInRow).toChar)
    yield(n, letter))
      .toList
      .map(x => seatId(x._1, x._2))
  }
}