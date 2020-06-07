import 'package:flutter/material.dart';
import 'package:cprambaskettrackingapp/theme/style.dart';
import 'package:cprambaskettrackingapp/routes.dart';
import 'package:cprambaskettrackingapp/bloc/bloc-prov-tree.dart';
import 'package:cprambaskettrackingapp/bloc/bloc-prov.dart';
import 'package:cprambaskettrackingapp/blocs/blocs.dart';
import 'blocs/blocs.dart';

void main() {
  runApp(Main());
}

class Main extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return BlocProviderTree(
      blocProviders: <BlocProvider>[
        BlocProvider<AuthBloc>(bloc: AuthBloc()),
        BlocProvider<PrefBloc>(bloc: PrefBloc()),
      ],
      child: MaterialApp(
        title: 'ExampleApp',
        theme: appTheme(),
        initialRoute: '/',
        routes: routes,
      ),
    );
  }
}
