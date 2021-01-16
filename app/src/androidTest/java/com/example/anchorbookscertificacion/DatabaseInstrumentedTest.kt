package com.example.anchorbookscertificacion

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Dao
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.anchorbookscertificacion.model.db.AnchorDB
import com.example.anchorbookscertificacion.model.db.AnchorDao
import com.example.anchorbookscertificacion.model.entities.BooksEntity
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseInstrumentedTest {
    private lateinit var anchorDao: AnchorDao
    private lateinit var db: AnchorDB
    val context = ApplicationProvider.getApplicationContext<Context>()

    @get:Rule
    var instantTastkExectorTest = InstantTaskExecutorRule()
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Truth.assertThat("com.example.anchorbookscertificacion").isEqualTo(appContext.packageName)
    }

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            context, AnchorDB::class.java).build()
        anchorDao = db.dao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertarYobtenerLibros()= runBlocking {
        val book1 = BooksEntity(1,
            "yo",
            "Chile",
            "Imagen",
            "sunny",
            "sunny"
        )
        val listaLibro = listOf<BooksEntity>(
            book1
        )
        anchorDao.insertBooks(listaLibro)

        anchorDao.getAllBooks().observeForever {
                listaRes ->
            Truth.assertThat(listaLibro).isEqualTo(listaRes)
        }

    }

}