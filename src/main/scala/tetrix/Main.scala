package tetrix


import scala.{swing => S}
import scala.swing.event.{KeyPressed, Key}

object Main extends S.SimpleSwingApplication {
  import java.awt.{Color => AWTColor}

  val bluishGray = new AWTColor(48, 99, 99)
  val bluishSilver = new AWTColor(210, 255, 255)
  val ui = new AbstractUI

  def onKeyPress(keyCode: Key.Value) = keyCode match {
    case Key.Left => ui.left()
    case Key.Right => ui.right()
    case Key.Up => ui.up()
    case Key.Down => ui.down()
    case Key.Space => ui.space()
    case _ =>
  }

  def onPaint(g: S.Graphics2D): Unit = {
    g setColor bluishSilver
    g drawString (ui.last, 20, 20)
  }

  override def top: S.Frame = new S.MainFrame {
    title = "Hello"
    contents = mainPanel
  }

  def mainPanel = new S.Panel {
    preferredSize = new S.Dimension(700, 400)
    focusable = true
    listenTo(keys)
    reactions += {
      case KeyPressed(_, key, _, _) =>
        onKeyPress(key)
        repaint()
    }

    override def paint(g: S.Graphics2D): Unit = {
      g setColor bluishGray
      g fillRect (0, 0, size.width, size.height)
      onPaint(g)
    }
  }
}
