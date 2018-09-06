package org.swineproject.shoat.widgets

import org.eclipse.swt.widgets.Canvas
import org.eclipse.swt.widgets.Composite


class UpdatingCanvas(parent: Composite, style: Int) : Canvas(parent, style) {
    init {
        val self = this

        val delay = 24
        val timer = object : Runnable {
            override fun run() {
                if (!self.isDisposed) {
                    self.redraw()
                }

                display.timerExec(delay, this)
            }
        }

        display.timerExec(delay, timer)
    }
}