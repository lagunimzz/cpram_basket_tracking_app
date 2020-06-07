import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

const _channel = const EventChannel('events');
typedef void Listener(dynamic msg);
typedef void CancelListening();

class Body extends StatefulWidget {
  @override
  _BodyState createState() => _BodyState();
}

class _BodyState extends State<Body> {
  int nextListenerId = 1;

  static const platform = const MethodChannel('th.co.cpram.rfiddriver');

  String _batteryLevel = 'Unknown battery level.';

  static const stream = const EventChannel('th.co.cpram.rfiddriver');

  String _timer = '';
  StreamSubscription _timerSubscription;
  List<String> _tests = new List<String>();
  void _enableTimer() {
    if (_timerSubscription == null) {
      _timerSubscription = stream.receiveBroadcastStream().listen(_updateTimer);
    }
  }

  void _disableTimer() {
    if (_timerSubscription != null) {
      _timerSubscription.cancel();
      _timerSubscription = null;
    }
  }

  void _updateTimer(tag) {
    setState(() => _tests.add(tag));
  }

  Widget build(BuildContext context) {
    _enableTimer();
//    runPlayground();
    return Container(
//      width: 100,
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
            children: _tests == null
                ? []
                : _tests
                    .map((e) => Container(
                          child: Text(e),
                        ))
                    .toList()

////        mainAxisAlignment: MainAxisAlignment.center,
//              children: <Widget>[
//                new Flexible(
//                  child: new TextField(
//                    decoration:
//                        const InputDecoration(helperText: "Enter App ID"),
//                    style: Theme.of(context).textTheme.bodyText1,
//                  ),
//                ),
//                SizedBox(
//                  width: 10,
//                ),
//                RaisedButton(
//                  child: Text('Test'),
//                  onPressed: () => _enableTimer(),
//                )
//              ],
//            ),
//            Text(_batteryLevel),
//          ],
            ),
      ),
    );
  }
}
