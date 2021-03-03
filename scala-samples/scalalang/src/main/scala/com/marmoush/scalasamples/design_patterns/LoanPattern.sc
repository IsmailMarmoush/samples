import java.io.{File, FileInputStream}

/* http://stackoverflow.com/questions/20762240/loan-pattern-in-scala */
def readFile[T](f: File)(handler: FileInputStream => T): T = {
  val resource = new java.io.FileInputStream(f)
  try {
    handler(resource)
  } finally {
    resource.close()
  }
}
readFile(new java.io.File("test.txt")) { input =>
  println(input.read)
}