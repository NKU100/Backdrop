package com.kyant.backdrop.highlight

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.kyant.backdrop.RuntimeShaderCache

@Immutable
data class DefaultHighlightStyle(
    override val color: Color = Color.White.copy(alpha = 0.5f),
    override val blendMode: BlendMode = BlendMode.Plus,
    val angle: Float = 45f,
    val falloff: Float = 1f
) : HighlightStyle {

    override fun DrawScope.createShader(
        shape: Shape,
        runtimeShaderCache: RuntimeShaderCache
    ): Shader? {
        // TODO: implement SkSL-based highlight shader for wasmJs
        return null
    }
}

@Immutable
data class AmbientHighlightStyle(
    val intensity: Float = 0.38f
) : HighlightStyle {

    override val color: Color = Color.White.copy(alpha = intensity)

    override val blendMode: BlendMode = DrawScope.DefaultBlendMode

    override fun DrawScope.createShader(
        shape: Shape,
        runtimeShaderCache: RuntimeShaderCache
    ): Shader? {
        // TODO: implement SkSL-based ambient highlight shader for wasmJs
        return null
    }
}

internal actual fun expect_DefaultHighlightStyle(): HighlightStyle = DefaultHighlightStyle()
internal actual fun expect_AmbientHighlightStyle(): HighlightStyle = AmbientHighlightStyle()
