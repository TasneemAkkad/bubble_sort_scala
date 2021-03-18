object BubbleSort
{
  //bubble sort sıralaması kullanmak için bir ana fonksiyon oluşturduk, bu fonksiyon diziyi parametre olarak alıyor
  def bubbleSort(array: Array[Int]) = 
  {
     //gerçek bubble sort sıralayan fonksiyon, parametreleri:  int tipinde dizi,  current bir pointer gibi düşünebiliriz, 
     //bu değişken dizinin içinde gezerek bütün indexleri kontrol edecek,
     //to parametresi ise wall yada sınır gibi düşünebiliriz (sıralayan sayıların bir daha sıralamaması için sağlayan)
    def bubbleSortRecursive(array: Array[Int], current: Int, to: Int): Array[Int] =
    {
        //adım adım sonucu yazdır 
        println( array.mkString(",") + "    whalk through -> " + current + ", to -> " + to)
        to match
        {
          case 0 => array
          case _ if(to == current) => bubbleSortRecursive(array, 0, to - 1)
          case _ =>
          // 1. eleman ile 2. eleman karşılaştırılır, eğer 1., 2.dan büyük ise swap işlemi yap(yer değiştirme yöntemi)
            if (array(current) > array(current + 1)) 
            {
                //swap işlemleri
            var temp = array(current + 1)
            array(current + 1) = array(current)
            array(current) = temp
            }
            //current'i bir adım ilerliyoruz
          bubbleSortRecursive(array, current + 1, to)
        }
    }
    //to değişkeni her bi tour sonunu bir azalıyor
    //to değişkeni azalarak dizinin sonunak kadar ulaşmış oluruz
    bubbleSortRecursive(array, 0, array.size - 1)
  }
      //main: ana fonksiyor
  def main(args: Array[String]) =
  {
    //r random(restgele) sayılar üretmeye sağlar
    val r = scala.util.Random
    //bu for yapısı 10 sayı üretmek için, sayıların 0-100 aralığında
    val arr = for (i <- 1 to 10) yield r.nextInt(100) 
    //bubbleSort fonksiyonu çağırıyoruz
    val sortedArray =  bubbleSort(arr.toArray)
    //sonucu yazdırıyoruz(dizinin son hali) sıralanmış hali
    println("Sorted Array -> " + sortedArray.mkString(","))
  }
  
}
