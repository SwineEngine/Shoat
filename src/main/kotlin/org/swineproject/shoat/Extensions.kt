package org.swineproject.shoat

import org.eclipse.swt.internal.win32.OS
import org.eclipse.swt.internal.win32.TCHAR
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Spinner
import org.eclipse.swt.widgets.Widget


fun Spinner.setText(value: String) {
    val checkWidget = Widget::class.java.getDeclaredMethod("checkWidget")
    checkWidget.isAccessible = true
    val getCodePage = Control::class.java.getDeclaredMethod("getCodePage")
    getCodePage.isAccessible = true

    val hwndText = Spinner::class.java.getDeclaredField("hwndText")
    hwndText.isAccessible = true

    checkWidget.invoke(this)
    val buffer = TCHAR(getCodePage.invoke(this).toString().toInt(), value, true)

    OS.SetWindowText(hwndText.getLong(this), buffer)
}