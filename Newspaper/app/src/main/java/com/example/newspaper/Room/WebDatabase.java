package com.example.newspaper.Room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Website.class}, version = 1)
public abstract class WebDatabase extends RoomDatabase {

    private static WebDatabase instance;

    public abstract WebDao webDao();

    public static synchronized WebDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), WebDatabase.class, "web_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private WebDao webDao;

        private PopulateDbAsyncTask(WebDatabase db) {
            webDao = db.webDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            webDao.insert(new Website(
                    "https://www.foxbusiness.com/economy/elon-musk-manufacture-tesla-cars-india-government",
                    "Elon Musk won't manufacture Tesla cars in India because government prohibits selling and servicing of EVs - Fox Business",
                    "https://a57.foxnews.com/static.foxbusiness.com/foxbusiness.com/content/uploads/2022/02/0/0/elon-musk-split.jpg?ve=1&tl=1"
            ));

            webDao.insert(new Website(
                    "https://en.as.com/latest_news/usa-finance-and-payments-live-updates-400-check-car-owners-child-tax-credit-ss-disability-n/",
                    "USA finance and payments live updates: $400 check car owners, Child Tax Credit, S.S. disability... - AS USA",
                    "https://img.asmedia.epimg.net/resizer/V_-W2uO_s8Z-erKjoHdWhaiVGLM=/644x362/cloudfront-eu-central-1.images.arcpublishing.com/diarioas/SF4BETJAJGHVQWDVK5PH4CYO74.jpg"
            ));

            webDao.insert(new Website(
                    "https://www.cnn.com/2022/05/28/football/champions-league-final-liverpool-real-madrid-spt-intl/index.html",
                    "Real Madrid beats Liverpool to win Champions League title on a night marred by security issues - CNN",
                    "https://media.cnn.com/api/v1/images/stellar/prod/220528220457-real-madrid-vinicius.jpg?c=16x9&q=w_800,c_fill"
            ));

            return null;
        }
    }
}
