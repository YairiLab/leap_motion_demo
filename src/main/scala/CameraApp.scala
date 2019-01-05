import scala.collection.JavaConversions._
import processing.core._
import processing.core.PConstants.RGB
import com.leapmotion.leap._

class CameraApp extends PApplet {
  var cam: PImage = null
  var controller: Controller = null
  val listener = new CameraListener()
  var fingers  = List[PVector]()

  override def settings() {
    size(700, 300)
    controller = new Controller()
    controller.addListener(listener)
  }

  override def setup() {
    controller.setPolicy(Controller.PolicyFlag.POLICY_IMAGES)

    frameRate(1)
    noStroke()
    fill(200)
  }

  override def draw() {
    if(cam != null) {
      image(cam, 0, 0)
    }
  }

  class CameraListener extends Listener {
    override def onFrame(controller: Controller) {
      val frame = controller.frame
      if (frame.isValid) {
        val img = frame.images.head
        cam = createImage(img.width, img.height, RGB)
        cam.loadPixels()
        val data = img.data
        for(i <- 0 until data.length) {
          val v = data(i) & 0xFF
          cam.pixels(i) = color(v)
        }
        cam.updatePixels()
      }
    }
  }

}