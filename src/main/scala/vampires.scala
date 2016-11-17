import scala.collection.mutable.ArrayBuffer
/**
  * 吸血鬼数字是指位数为偶数的数字，可以有一堆数字相乘得到，而这对数字包含积的对半的位数，
  * 且两个0结束的数字是不允许的
  * examples: The 7 vampires with 4 digits
  * 1260 = 21 * 60, 1395 = 15 * 93, 1435 = 35 * 41, 1530 = 30 * 51, 1827 = 21 * 87,  2187 = 27 * 81, 6880 = 80 * 86
  * Created by WLZhong on 2016/11/17.
  */
object vampires extends App
{
  //防止找出重复的
  var result = ArrayBuffer[Int]()

  //两位数：共有90*90=8100,
  for(i <- 10 to 99)
  {
    for (j <- 10 to 99)
    {
      val temp = i * j
      //限定为所有的4位数，是否之前已找出，去除为两个00，
      if (!result.contains(temp) && (temp % 100 != 0) && temp > 1000 && temp < 10000)
      {
        val tv4 = temp.toString.toList
        val tv = (i.toString+j.toString).toList
        val tvv1 = tv4.sortWith(_>_)
        val tvv2 = tv.sortWith(_>_)

        //排序之后，判断是否相等
        if(tvv1.equals(tvv2))
        {
          result+=temp
          println("vampires: "+temp.toString+"="+i.toString+"*"+j.toString)
        }
      }
    }
  }
}

