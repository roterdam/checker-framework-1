package checkers.signature;

import checkers.signature.quals.*;

import checkers.basetype.BaseTypeChecker;
import checkers.quals.TypeQualifiers;
import checkers.types.AnnotatedTypeFactory;
import com.sun.source.tree.CompilationUnitTree;

@TypeQualifiers({
    BinaryName.class,
    FullyQualifiedName.class,
    SourceName.class,
    FieldDescriptor.class,
    MethodDescriptor.class,
    UnannotatedString.class,
    SignatureBottom.class
})
public final class SignatureChecker extends BaseTypeChecker {

  // This method is needed only under MacOS, perhaps as a result of the
  // broken Apple Java distribution.
  public AnnotatedTypeFactory createFactory(CompilationUnitTree root) {
    return new SignatureAnnotatedTypeFactory(this, root);
  }

}