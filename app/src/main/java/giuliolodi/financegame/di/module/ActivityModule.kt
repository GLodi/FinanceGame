package giuliolodi.financegame.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import giuliolodi.financegame.di.scope.ActivityContext
import giuliolodi.financegame.di.scope.PerActivity
import giuliolodi.financegame.ui.fragment.FragmentContract
import giuliolodi.financegame.ui.fragment.FragmentPresenter
import giuliolodi.financegame.ui.main.MainContract
import giuliolodi.financegame.ui.main.MainPresenter
import giuliolodi.financegame.ui.stock.StockContract
import giuliolodi.financegame.ui.stock.StockPresenter
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(val activity: Activity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @PerActivity
    fun provideMainPresenter(presenter: MainPresenter<MainContract.View>): MainContract.Presenter<MainContract.View> {
        return presenter
    }

    @Provides
    fun provideFragmentPresenter(presenter: FragmentPresenter<FragmentContract.View>): FragmentContract.Presenter<FragmentContract.View> {
        return presenter
    }

    @Provides
    fun provideStockPresenter(presenter: StockPresenter<StockContract.View>): StockContract.Presenter<StockContract.View> {
        return presenter
    }

}