package com.marmoush.scalasamples.concepts

object MySheet {
  println("Welcome to the Scala worksheet")

  type EmailFilter = Email => Boolean
  //> newMailsForUser: (mails: Seq[com.marmoush.scalasamples.concepts.MySheet.Emai
  //| l], f: com.marmoush.scalasamples.concepts.MySheet.EmailFilter)Seq[com.marmou
  //| sh.scalasamples.concepts.MySheet.Email]
  val sentByOneOf: Set[String] => EmailFilter =
    senders => email => senders.contains(email.sender)
  //> sentByOneOf  : Set[String] => com.marmoush.scalasamples.concepts.MySheet.Ema
  //| ilFilter = <function1>
  val notSentByAnyOf: Set[String] => EmailFilter =
    senders => email => !senders.contains(email.sender)
  //> notSentByAnyOf  : Set[String] => com.marmoush.scalasamples.concepts.MySheet.
  //| EmailFilter = <function1>
  val minimumSize: Int => EmailFilter = n => email => email.text.size >= n
  //> minimumSize  : Int => com.marmoush.scalasamples.concepts.MySheet.EmailFilter
  //|  = <function1>
  val maximumSize: Int => EmailFilter = n => email => email.text.size <= n

  def newMailsForUser(mails: Seq[Email], f: EmailFilter) = mails.filter(f)

  //> Welcome to the Scala worksheet
  case class Email(
                    subject: String,
                    text: String,
                    sender: String,
                    recipient: String)
  //> maximumSize  : Int => com.marmoush.scalasamples.concepts.MySheet.EmailFilter
  //|  = <function1>


}