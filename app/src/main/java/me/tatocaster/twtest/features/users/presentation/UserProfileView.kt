package me.tatocaster.twtest.features.users.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.widget.Recycler
import com.facebook.litho.widget.RecyclerBinder
import me.tatocaster.twtest.App
import me.tatocaster.twtest.AppComponent
import me.tatocaster.twtest.features.users.models.User
import me.tatocaster.twtest.features.users.presentation.layout.UserItem
import me.tatocaster.twtest.features.users.presentation.layout.UserItemFullScreen
import me.tatocaster.twtest.features.users.presentation.layout.UserLayout
import javax.inject.Inject


/**
 * Created by tatocaster on 12.10.17.
 */
class UserProfileView : AppCompatActivity(), UserProfileContract.View {

    @Inject
    lateinit var presenter: UserProfileContract.Presenter

    private lateinit var scopeGraph: UserProfileComponent

    private lateinit var mComponentContext: ComponentContext

    private lateinit var mRecyclerBinder: RecyclerBinder

    private var mSingleView: Boolean = true

    private lateinit var mRootView: LithoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupScopeGraph(App.getAppContext(this).appComponent)

        initViews()

        mRootView = LithoView.create(
                this,
                UserLayout.create(mComponentContext)
                        .binder(mRecyclerBinder)
                        .build()
        )

        setContentView(mRootView)
        presenter.onCreate()

    }

    override fun loadUserList(users: List<User>) {
        renderData(users)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }


    private fun initViews() {
        mComponentContext = ComponentContext(this)
        mRecyclerBinder = RecyclerBinder.Builder().build(mComponentContext)
    }

    private fun renderData(users: List<User>) {
        if (mRecyclerBinder.itemCount == 1) {
            mRecyclerBinder.removeItemAt(0)
        }
        for ((index, value) in users.withIndex()) {
            mRecyclerBinder.insertItemAt(index, UserItem.create(mComponentContext)
                    .user(value)
                    .listener {
                        mRootView.setComponentAsync(UserItemFullScreen.create(mComponentContext).user(value).build())
                        mSingleView = true
                    }
                    .build())
        }
    }

    override fun closeRealm() {
        presenter.closeRealm()
    }

    override fun showError(e : Exception) {
        Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
    }

    private fun setupScopeGraph(appComponent: AppComponent) {
        scopeGraph = DaggerUserProfileComponent.builder()
                .appComponent(appComponent)
                .userProfileModule(UserProfileModule(this))
                .build()
        scopeGraph.inject(this)
    }

    override fun onBackPressed() {
        if (mSingleView) {
            mSingleView = false
            mRootView.setComponentAsync(Recycler.create(mComponentContext).binder(mRecyclerBinder).build())
            return
        }
        super.onBackPressed()
    }

    companion object {
        private val TAG = "UserProfileView"
    }
}