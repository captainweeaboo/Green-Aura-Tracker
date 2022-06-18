package momj.gat.common.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class ControllerCoroutineScope : CoroutineScope {
    override val coroutineContext = Dispatchers.Default + Job()
}
