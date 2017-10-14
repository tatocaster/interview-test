package me.tatocaster.twtest.features.users.presentation.layout

import android.graphics.Color
import com.facebook.litho.Column
import com.facebook.litho.ComponentContext
import com.facebook.litho.ComponentLayout
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Recycler
import com.facebook.litho.widget.RecyclerBinder

/**
 * Created by tatocaster on 13.10.17.
 */
@LayoutSpec
class UserLayoutSpec {
    companion object {

        @JvmStatic
        @OnCreateLayout
        fun onCreateLayout(context: ComponentContext, @Prop binder: RecyclerBinder): ComponentLayout {

            return Column.create(context)
                    .child(
                            Recycler.create(context).binder(binder).build()
                    )
                    .backgroundColor(Color.WHITE)
                    .build()
        }
    }
}