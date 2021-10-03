package com.example.newsn.ui.HomeScreen.util

import androidx.compose.animation.core.KeyframesSpec
import androidx.dynamicanimation.animation.FloatValueHolder

object ShimmerAnimationDefinitions{

    enum class AnimationState{
        START,END
    }

    val xShimmerPropKey = FloatValueHolder("xShimmer")
}