package me.tatocaster.twtest.features.users.presentation.layout

import android.graphics.Typeface
import android.view.View
import com.facebook.litho.*
import com.facebook.litho.annotations.*
import com.facebook.litho.widget.Text
import com.facebook.litho.widget.VerticalGravity
import com.facebook.yoga.YogaEdge
import me.tatocaster.twtest.R
import me.tatocaster.twtest.features.users.models.User

/**
 * Created by tatocaster on 13.10.17.
 */
@LayoutSpec
class UserItemSpec {
    companion object {

        @JvmStatic
        @OnCreateLayout
        fun onCreateLayout(context: ComponentContext, @Prop user: User, @Prop(optional = true) textColor: Int?): ComponentLayout =
                Row.create(context)
                        .paddingDip(YogaEdge.ALL, 8)
                        .minHeightDip(60)
                        .child(
                                Column.create(context)
                                        .child(
                                                Text.create(context)
                                                        .text(user.name)
                                                        .textSizeSp(14f)
                                                        .textStyle(Typeface.BOLD)
                                                        .textColorRes(textColor ?: R.color.black)
                                                        .verticalGravity(VerticalGravity.CENTER)
                                                        .withLayout()
                                                        .build())
                                        .child(
                                                Text.create(context)
                                                        .text(user.username)
                                                        .textSizeSp(12f)
                                                        .textColorRes(R.color.gray)
                                                        .verticalGravity(VerticalGravity.CENTER)
                                                        .withLayout()
                                                        .marginDip(YogaEdge.TOP, 4)
                                                        .build())
                                        .child(
                                                Text.create(context)
                                                        .text(user.email)
                                                        .textSizeSp(12f)
                                                        .textColorRes(R.color.gray)
                                                        .textStyle(Typeface.BOLD)
                                                        .verticalGravity(VerticalGravity.CENTER)
                                                        .withLayout()
                                                        .marginDip(YogaEdge.TOP, 4)
                                                        .build())
                        )
                        .clickHandler(UserItem.onClick(context))
                        .build()

        @OnEvent(ClickEvent::class)
        @JvmStatic
        fun onClick(c: ComponentContext, @FromEvent view: View, @Prop(optional = true) listener: View.OnClickListener?) {
            listener?.onClick(view)
        }
    }
}