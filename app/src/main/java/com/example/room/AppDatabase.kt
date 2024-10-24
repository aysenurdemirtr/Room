package com.example.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.data.entitys.person.Person
import com.example.room.data.entitys.person.PersonDao


// represent a database in room lib.
// contains database folder and main access connections to our data.
// exportSchema means :

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // Alt sınıflar bu ortak özellikleri miras alır ve
    // ihtiyaç duyduklarında özelleştirebilirler.

    abstract fun personDao(): PersonDao

    companion object {
        //ile işaretlenmiş bir değişken, bir iş parçacığı tarafından güncellendiğinde,
        // bu değişiklik diğer iş parçacıkları tarafından hemen görülebilir.
        // Yani, bu değişkenin değeri her zaman en güncel haliyle erişilebilir.
        //karmaşık veri yapılarında tam bir senkronizasyon sağlamaz.
        // Özellikle, birden fazla değişkenle işlem yapıldığında,
        // bu anotasyon yeterli olmayabilir.
        @Volatile
        private var Instance: AppDatabase? = null

        // Bu fonksiyon, PersonDatabase nesnesinin güvenli bir şekilde tekil (singleton) olarak yönetilmesini sağlar.
        // Eğer veritabanı zaten oluşturulmuşsa, mevcut örneği döndürür; yoksa yeni bir örnek oluşturur.
        // synchronized bloğu, bu işlemin çok iş parçacıklı ortamlarda güvenli olmasını sağlar, böylece
        // aynı anda birden fazla iş parçacığı yeni bir örnek oluşturmaya çalışmaz.
        // Bu yapı, veritabanı erişim performansını artırır ve uygulama içinde tutarlılığı sağlar.

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = Instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    name = "person_database"
                ).allowMainThreadQueries().build()
                Instance = instance
                return instance
            }
        }
    }
}
// allowMainThreadQueries() db'i ana threadden de erişebileceğim demek.
// hepsini suspend olarak görür. yoksa patlar app.