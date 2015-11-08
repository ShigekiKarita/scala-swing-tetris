package tetrix


class AbstractUI {
  private [this] var lastKey: String = ""

  def left(): Unit = {
    lastKey = "left"
  }

  def right(): Unit = {
    lastKey = "right"
  }

  def up(): Unit = {
    lastKey = "up"
  }

  def down(): Unit = {
    lastKey = "down"
  }

  def space(): Unit = {
    lastKey = "space"
  }

  def last = lastKey
}
