trait TraceHashCode {
  override def hashCode: Int = {
    println(s"TRACE: In hashCode for ${this}")
    super.hashCode
  }
}

// mix in trait at instantiation
case class Country(isoCode: String)

def newSwitzInst = new Country("CH") with TraceHashCode

// mix in trait at declaration time
case class CountryWithTrace(isoCode: String) extends
TraceHashCode

def newSwitzDecl = CountryWithTrace("CH")

import scala.collection.immutable.HashSet

val countriesInst = HashSet(newSwitzInst)
println(countriesInst.iterator contains newSwitzInst)
println(countriesInst contains newSwitzInst)

val countriesDecl = HashSet(newSwitzDecl)
println(countriesDecl.iterator contains newSwitzDecl)
println(countriesDecl contains newSwitzDecl)