package me.tatocaster.twtest.features.users.presentation.layout

import com.facebook.litho.Column
import com.facebook.litho.ComponentContext
import com.facebook.litho.ComponentLayout
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaEdge
import me.tatocaster.twtest.R
import me.tatocaster.twtest.features.users.models.User

/**
 * Created by tatocaster on 14.10.17.
 */
@LayoutSpec
class UserItemFullScreenSpec {
    companion object {

        @JvmStatic
        @OnCreateLayout
        fun onCreateLayout(context: ComponentContext, @Prop user: User): ComponentLayout =
                Column.create(context)
                        .backgroundRes(R.color.darkBlue)
                        .child(
                                UserItem.create(context)
                                        .user(user)
                                        .textColor(R.color.white)
                                        .build()
                        )
                        .child(
                                Text.create(context)
                                        .text(user.getFullAddress())
                                        .textSizeSp(12f)
                                        .textColorRes(R.color.gray)
                                        .withLayout()
                                        .paddingDip(YogaEdge.ALL, 8)
                                        .marginDip(YogaEdge.TOP, 4)
                                        .build())
                        .child(
                                Text.create(context)
                                        .text(user.getCompanyInfo())
                                        .textSizeSp(12f)
                                        .textColorRes(R.color.gray)
                                        .withLayout()
                                        .paddingDip(YogaEdge.ALL, 8)
                                        .marginDip(YogaEdge.TOP, 4)
                                        .build())
                        .build()

    }
}