package com.jupiter.application.path

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View

class shape(context: Context) : View(context), ScaleGestureDetector.OnScaleGestureListener {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path:Path = Path()
    //var xPos:Float = 200f
    //var yPos:Float = 200f
    var triX:Float = 200f
    var triY:Float = 200f
    var sqX:Int =0
    var sqY:Int =0
    lateinit var sg: ScaleGestureDetector
    var factor:Float = 1.0f
    init {
        sg = ScaleGestureDetector(context,this)
    }
    override fun onDraw(canvas: Canvas) {
        triX = (canvas.width/2).toFloat()
        triY = (canvas.height/2).toFloat()
        sqX = triX.toInt()
        sqY = triY.toInt()
        super.onDraw(canvas)
        canvas.drawColor(Color.LTGRAY)
        paint.color = Color.RED
        path.moveTo(triX,triY)
        path.lineTo(triX-40, triY+60)
        path.lineTo(triX+40, triY+60)
        //path.close()
        var rct:Rect = Rect(sqX-40,sqY+80,sqX+40,sqY+140)
        canvas.drawPath(path,paint)
        canvas.drawRect(rct,paint)
        canvas.drawCircle(triX,triY+200,44F,paint)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
      //  xPos = event.getX()
      //  yPos = event.getY()
        invalidate()
        sg.onTouchEvent(event)
        return true
    }

    override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
        return true
    }

    override fun onScaleEnd(detector: ScaleGestureDetector?) {

    }

    override fun onScale(detector: ScaleGestureDetector?): Boolean {
        factor+=sg.getScaleFactor()-1
        return true
    }
}