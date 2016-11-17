/**
  * Created by WLZhong on 2016/11/17.
  */

object narcissisticNumber extends App
{
  def pow(n:BigInt, m:BigInt):BigInt = if (m==0) 1 else pow(n,m-1)*n
  for(i <- 1 to 10000)
  {
    val num = i
    val strNum = i.toString
    val lenth = strNum.length
    var product: BigInt = 0
    for(i <- strNum)
    {
      val temp = i.toInt - 48
      product = product + pow(temp,lenth)
    }
    if(product == num)
    {
      println("NarcissisticNumber:"+ num)
    }
  }

}
