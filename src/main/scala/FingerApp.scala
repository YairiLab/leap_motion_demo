import scala.collection.JavaConversions._
import processing.core._
import com.leapmotion.leap._

class FingerApp extends PApplet {
  var controller: Controller = null
  val listener = new FingerListener()
  var fingers  = List[PVector]()

  override def settings() {
    size(800, 600)
    controller = new Controller()
    controller.addListener(listener)
  }

  override def setup() {
    noStroke()
    fill(240)
  }

  override def draw() {
    background(40)
    translate(width/2, height)
    scale(1, -1)
    println(s"$frameCount: $fingers")
    for(f <- fingers) {
      ellipse(f.x, f.y, 30, 30)
    }
  }

  class FingerListener extends Listener {
    override def onFrame(controller: Controller) {
      val frame = controller.frame
      val fs = frame.fingers map { f =>
        val p = f.tipPosition
        new PVector(p.getX, p.getY)
      }
      fingers = fs.toList
    }
  }
}
